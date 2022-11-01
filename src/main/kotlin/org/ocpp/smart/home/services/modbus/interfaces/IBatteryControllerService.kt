package org.ocpp.smart.home.services.modbus.interfaces

import org.battery.controller.util.controller.modbusSimulator.ModbusCommand
import org.battery.controller.util.controller.modbusSimulator.commands.ModbusRequest
import org.battery.controller.util.controller.modbusSimulator.commands.ModbusResponse
import org.battery.controller.util.manufacturers.enums.Manufacturer

/**
 * Battery controller service.
 */
interface IBatteryControllerService {

    /**
     * Authorize at controller.
     */
    fun authorize()

    /**
     * Get all available Modbus commands for registered manufacturer.
     *
     * @return List of available Modbus commands.
     */
    fun getAllAvailableCommand(): List<ModbusCommand>

    /**
     * Send Modbus command to the battery controller.
     *
     * @param request .
     * @return Modbus response.
     */
    fun sendCommand(request: ModbusRequest): ModbusResponse

    /**
     * Get registered manufacturer enum.
     *
     * @return Manufacturer enum.
     */
    fun getManufacturerEnum(): Manufacturer
}
