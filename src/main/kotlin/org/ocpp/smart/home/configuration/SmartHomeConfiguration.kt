package org.ocpp.smart.home.configuration

import org.isc.utils.utils.Ids
import org.ocpp.client.application.Organisation

/**
 *
 */
object SmartHomeConfiguration {

    /**
     *
     */
    const val idTag: String = Organisation.validationId

    /**
     *
     */
    val vendorId: String = Ids.getRandomId()
}
