package com.codelog.rkimer

import com.codelog.rkimer.controller.MainController
import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage
import java.net.URL
import kotlin.system.exitProcess

class App: Application() {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            App().launchApp(args)
        }

        var currentScene: Scene? = null
        var currentStage: Stage? = null
    }

    fun launchApp(args: Array<String>) {
        launch(*args)
    }

    override fun start(primaryStage: Stage) {
        currentScene = null
        val file: URL = javaClass.classLoader.getResource("fxml/main.fxml") ?: exitProcess(-1)

        val root: Parent = FXMLLoader.load(file)

        val scene = Scene(root)
        val styleResource = javaClass.classLoader.getResource("style.css")
        if (styleResource != null)
            scene.stylesheets.add(styleResource.toExternalForm())
        currentScene = scene
        primaryStage.scene = scene

        primaryStage.title = "RKimer"
        primaryStage.isResizable = false

        MainController.scene = scene
        currentStage = primaryStage
        MainController.registerEvents()

        primaryStage.show()
    }
}