package org.ocpp.smart.home.configuration

import org.isc.utils.utils.Ids

/**
 *
 */
object SmartHomeConfiguration {

    /**
     *
     */
    val idTag: String = Ids.getRandomIdentifier().toString()

    /**
     *
     */
    val vendorId: String = Ids.getRandomId()
}
