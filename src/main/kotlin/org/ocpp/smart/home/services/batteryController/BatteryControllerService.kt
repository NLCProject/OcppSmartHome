package org.ocpp.smart.home.services.batteryController

import org.ocpp.smart.home.services.batteryController.interfaces.IBatteryControllerInitService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class BatteryControllerService: IBatteryControllerInitService {

    @Value("\${ocpp.battery.manufacturer}")
    lateinit var manufacturer: String

    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun authorize() {
        if (manufacturer.isEmpty())
            return logger.warn("No battery controller defined")

        logger.info("Registering smart home with battery controller '$manufacturer'")
        // TODO
    }
}
