package ru.otus.patterns

interface Camera {
    fun takePicture()
    fun addFilter()
}

interface Phone {
    fun makeCall()
    fun installApp()
}

class CameraPhone(private val camera: Camera, private val phone: Phone) : Camera, Phone {
    override fun takePicture() {
        camera.takePicture()
    }

    override fun addFilter() {
        camera.addFilter()
    }

    override fun makeCall() {
        phone.makeCall()
    }

    override fun installApp() {
        phone.installApp()
    }
}

