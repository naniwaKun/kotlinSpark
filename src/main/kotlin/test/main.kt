package test 

import java.io.File;
import spark.kotlin.*

fun main(args: Array<String>) {
	val http: Http = ignite()
staticFiles.location("/public")
	http.get("/hello") {
		var ret = "ああああああああああ"
		ret
	}
}
