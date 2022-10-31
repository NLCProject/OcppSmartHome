package org.ocpp.smart.home.services.modbus.interfaces

import org.battery.controller.util.controller.modbusSimulator.ModbusCommand
import org.battery.controller.util.controller.modbusSimulator.commands.ModbusRequest
import org.battery.controller.util.controller.modbusSimulator.commands.ModbusResponse
import org.battery.controller.util.manufacturers.enums.Manufacturer

/**
 *
 */
interface IBatteryControllerService {

    /**
     *
     */
    fun authorize()

    /**
     *
     */
    fun getAllAvailableCommand(): List<ModbusCommand>

    /**
     *
     */
    fun sendCommand(request: ModbusRequest): ModbusResponse

    /**
     *
     */
    fun getManufacturerEnum(): Manufacturer
}
