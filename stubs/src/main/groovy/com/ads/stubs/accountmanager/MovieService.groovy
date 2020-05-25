package com.ads.stubs.accountmanager

import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import groovy.util.logging.Slf4j
import spark.Service

import static spark.Service.ignite

@Slf4j
class MovieService {

    private static def CONFIG = new ConfigSlurper().parse(new File('etc/MovieService.groovy').toURI().toURL())

    static void main(String[] args) {
        def port = CONFIG.am.port
        Service service = ignite()
        service.port(port)
        log.info "Run AccountManager Service on ${port} ..."

        service.get('/favorites/actors') { request, response ->
            log.info('Getting favorite actors')
            response.type("application/json")
            def result = CONFIG.am.ok.actors.list.result
            return JsonOutput.toJson(result)
        }

        service.put('/favorites/actors/:actorId') { request, response ->
            //user_ud can be taken from auth_header
            def param = request.params('actorId')
            log.info('Updated favorite actors')
            response.type("application/json")
            return JsonOutput.toJson(param)
        }

        service.get('/favorites/movies') { request, response ->
            log.info('Getting favorite movies')
            response.type("application/json")
            def result = CONFIG.am.ok.movies.list.result
            return JsonOutput.toJson(result)
        }

        service.put('/favorites/movies/:movieId') { request, response ->
            def param = request.params('movieId')
            log.info('Updated favorite actors')
            response.type("application/json")
            return JsonOutput.toJson(param)
        }
    }

}
