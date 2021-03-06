package io.homeassistant.companion.android.domain.integration

interface IntegrationUseCase {

    suspend fun registerDevice(deviceRegistration: DeviceRegistration)
    suspend fun updateRegistration(
        appVersion: String? = null,
        deviceName: String? = null,
        manufacturer: String? = null,
        model: String? = null,
        osVersion: String? = null,
        pushUrl: String? = null,
        pushToken: String? = null
    )

    suspend fun getRegistration(): DeviceRegistration

    suspend fun isRegistered(): Boolean

    suspend fun updateLocation(updateLocation: UpdateLocation)

    suspend fun callService(domain: String, service: String, serviceData: HashMap<String, Any>)

    suspend fun fireEvent(eventType: String, eventData: Map<String, Any>)

    suspend fun scanTag(data: HashMap<String, Any>)

    suspend fun getZones(): Array<Entity<ZoneAttributes>>

    suspend fun setFullScreenEnabled(enabled: Boolean)
    suspend fun isFullScreenEnabled(): Boolean

    suspend fun sessionTimeOut(value: Int)
    suspend fun getSessionTimeOut(): Int

    suspend fun setSessionExpireMillis(value: Long)
    suspend fun getSessionExpireMillis(): Long

    suspend fun getServices(): Array<Service>

    suspend fun getEntities(): Array<Entity<Any>>

    suspend fun getThemeColor(): String

    suspend fun getHomeAssistantVersion(): String

    suspend fun getPanels(): Array<Panel>

    suspend fun registerSensor(sensorRegistration: SensorRegistration<Any>)

    suspend fun updateSensors(sensors: Array<SensorRegistration<Any>>): Boolean
}
