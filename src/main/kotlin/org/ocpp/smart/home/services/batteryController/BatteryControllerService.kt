package org.ocpp.smart.home.services.batteryController

import org.battery.controller.util.controller.modbusSimulator.ModbusCommand
import org.battery.controller.util.controller.modbusSimulator.commands.ModbusRequest
import org.battery.controller.util.controller.smartHomeConnector.ISmartHomeConnector
import org.battery.controller.util.manufacturers.enums.Manufacturer
import org.ocpp.smart.home.services.batteryController.interfaces.IBatteryControllerService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class BatteryControllerService @Autowired constructor(
    private val smartHomeConnector: ISmartHomeConnector
): IBatteryControllerService {

    @Value("\${ocpp.battery.manufacturer}")
    override lateinit var manufacturer: Manufacturer

    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun authorize() {
        logger.info("Registering smart home with battery controller '$manufacturer'")
        smartHomeConnector.registerManufacturer(manufacturer = manufacturer)
    }

    override fun getAllAvailableCommand(): List<ModbusCommand> {
        logger.info("Requesting available modbus commands")
        return smartHomeConnector.getAllAvailableCommand()
    }

    override fun sendCommand(request: ModbusRequest) {
        logger.info("Sending modbus request '${request.command}' with value '${request.value}'")
        smartHomeConnector.sendCommand(request = request)
    }
}
