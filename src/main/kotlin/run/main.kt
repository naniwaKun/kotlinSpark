package run

import java.io.File
import java.net.*
import spark.kotlin.*
import com.beust.klaxon.*

fun main(args: Array<String>) {
	var docs: String = getIcecastApi()
	println(docs)
		port(8088)
		val http: Http = ignite()

		http.get("/") {
			"${docs}"
		}
}

fun getIcecastApi(): String  {
	var ret: String  = ""
		val url = "http://live.cfw4.tk:8000/status-json.xsl"
		val jsonText = URL(url).readText()
		val stringBuilder: StringBuilder = StringBuilder(jsonText)
		val parser: Parser = Parser()
		val json: JsonObject = parser.parse(stringBuilder) as JsonObject
		val array = json.lookup<String?>("icestats.source.listenurl")

		if (array.get(0) == null){
			val statusBroadcast = false
				ret = "ほうそうなし"
		}else {
			val statusBroadcast = true
				ret = "${array.get(0)}"
		}
	return ret
}

