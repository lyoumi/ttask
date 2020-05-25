package com.ads.stubs

import com.ads.stubs.accountmanager.MovieService
import groovy.util.logging.Slf4j

@Slf4j
class Main {
    static void main(String[] args) {
        CliBuilder cli = new CliBuilder(usage: 'Run all stubs by default')

        def opt = cli.parse(args)

        def stubs = ['AM': { MovieService.main() }]
        if (!opt) return
        stubs.values()*.call()


    }
}
