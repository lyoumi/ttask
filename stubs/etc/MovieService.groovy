am {
    port = 9443

    ok {

        actors {
            list {
                status = 200
                result = [
                        actors: [
                                [
                                        id    : 'c80d8746-e858-4ecc-a6bd-f64feef4483c',
                                        name  : 'Jackie Chan',
                                        movies: [
                                                [
                                                        id   : '9b7139e9-7a96-4768-95da-4738e7786e6b',
                                                        title: 'Who am I?'
                                                ]
                                        ]
                                ]
                        ]
                ]
            }
            update {
                status = 200
            }
        }

        movies {
            list {
                status = 200
                result = [
                        movies: [
                                [
                                        id    : '9b7139e9-7a96-4768-95da-4738e7786e6b',
                                        title  : 'Who am I?',
                                        imdbRate: 6.8,
                                        description: 'Jackie wakes up in a tribal village somewhere in the African veldt, still recovering from injuries sustained in an accident he cannot remember; as a result, when asked for his name by the natives, he responds by asking himself, "Who Am I?", and is referred to as that by the natives. The tribesmen show him the remains of a crashed helicopter and graves of those who perished aboard. He spends weeks recuperating from his wounds and learning about the tribe\'s culture. After spotting rally cars from several miles away, "Who Am I?" bids the village farewell and ventures on a journey back to civilization. He befriends Japanese rally navigator Yuki after saving her brother from a snake bite and offering to help them finish the race.',
                                        actors: [
                                                [
                                                        id   : 'c80d8746-e858-4ecc-a6bd-f64feef4483c',
                                                        title: 'Jackie Chan'
                                                ]
                                        ]
                                ]
                        ]
                ]
            }
            update {
                status = 200
            }
        }

    }
}
