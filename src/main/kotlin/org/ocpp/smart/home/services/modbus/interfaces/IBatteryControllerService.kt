package org.ocpp.smart.home.services.modbus.interfaces

import org.battery.controller.util.controller.modbusSimulator.ModbusCommand
import org.battery.controller.util.controller.modbusSimulator.commands.ModbusRequest
import org.battery.controller.util.manufacturers.enums.Manufacturer
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener

/**
 *
 */
interface IBatteryControllerService {

    /**
     *
     */
    @EventListener(ApplicationReadyEvent::class)
    fun authorize()

    /**
     *
     */
    fun getAllAvailableCommand(): List<ModbusCommand>

    /**
     *
     */
    fun sendCommand(request: ModbusRequest)

    /**
     *
     */
    fun getManufacturerEnum(): Manufacturer
}
