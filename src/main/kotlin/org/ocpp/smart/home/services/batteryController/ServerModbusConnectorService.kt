package org.ocpp.smart.home.services.batteryController

import org.battery.controller.util.controller.modbusSimulator.commands.ModbusOnInit
import org.isc.utils.serialization.JsonSerialization
import org.ocpp.client.client.interfaces.IClientRequestService
import org.ocpp.smart.home.configuration.SmartHomeConfiguration
import org.ocpp.smart.home.exceptions.TypeUuidNotDefinedException
import org.ocpp.smart.home.services.batteryController.interfaces.IBatteryControllerService
import org.ocpp.smart.home.services.batteryController.interfaces.IServerModbusConnectorService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ServerModbusConnectorService @Autowired constructor(
    private val clientRequestService: IClientRequestService,
    private val batteryControllerService: IBatteryControllerService
): IServerModbusConnectorService, JsonSerialization() {

    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun sendAvailableCommandsOnInit() {
        logger.info("Sending available modbus commands to server on init")
        val dto = ModbusOnInit(
            manufacturer = batteryControllerService.getManufacturerEnum(),
            availableCommands = batteryControllerService.getAllAvailableCommand()
        )

        val data = super.encode(model = dto)
        if (!data.contains(dto.typeUuid))
            throw TypeUuidNotDefinedException()

        clientRequestService.dataTransfer(vendorId = SmartHomeConfiguration.vendorId, data = data)
    }
}
