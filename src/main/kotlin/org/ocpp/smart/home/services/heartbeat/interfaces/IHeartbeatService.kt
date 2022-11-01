package org.ocpp.smart.home.services.heartbeat.interfaces

/**
 * Heart beat service.
 */
interface IHeartbeatService {

    /**
     * Send heart beat to registered OCPP server.
     */
    fun sendHeartbeat()
}
