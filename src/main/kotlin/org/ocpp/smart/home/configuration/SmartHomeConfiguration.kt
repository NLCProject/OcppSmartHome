package org.ocpp.smart.home.configuration

import org.isc.utils.utils.Ids

/**
 * Smart home configuration.
 */
object SmartHomeConfiguration {

    /**
     * ID tag of this smart home.
     */
    val idTag: String = Ids.getRandomIdentifier().toString()

    /**
     * Vendor tag of this smart home.
     */
    val vendorId: String = Ids.getRandomId()
}
