package org.ocpp.smart.home.services.dataHandling

import org.battery.controller.util.controller.modbusSimulator.commands.CommandUUID
import org.battery.controller.util.controller.modbusSimulator.commands.ModbusRequest
import org.isc.utils.serialization.JsonSerialization
import org.ocpp.client.client.interfaces.IClientRequestService
import org.ocpp.client.event.client.request.ClientDataTransferRequestEvent
import org.ocpp.smart.home.configuration.SmartHomeConfiguration
import org.ocpp.smart.home.services.dataHandling.interfaces.IDataHandlingService
import org.ocpp.smart.home.services.modbus.interfaces.IBatteryControllerService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DataHandlingService @Autowired constructor(
    private val batteryController: IBatteryControllerService,
    private val clientRequestService: IClientRequestService
): IDataHandlingService, JsonSerialization() {

    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun handleIncomingDataTransfer(event: ClientDataTransferRequestEvent) {
        logger.info("Handling incoming data transfer")
        parsingAndHandleData(data = event.request.data)
    }

    private fun parsingAndHandleData(data: String) {
        logger.info("Parsing MODBUS data | $data")
        when {
            data.contains(CommandUUID.modbusRequest) -> {
                val request = super.decode<ModbusRequest>(data = data)
                val response = batteryController.sendCommand(request = request)
                clientRequestService.dataTransfer(
                    vendorId = SmartHomeConfiguration.vendorId,
                    data = super.encode(model = response)
                )
            }

            else -> throw Exception("Unknown or not defined UUID in received data | $data")
        }
    }
}
