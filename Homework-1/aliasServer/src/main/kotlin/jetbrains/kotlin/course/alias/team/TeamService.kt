package jetbrains.kotlin.course.alias.team

import jetbrains.kotlin.course.alias.util.Identifier
import jetbrains.kotlin.course.alias.util.IdentifierFactory
import org.springframework.stereotype.Service


@Service
class TeamService {
    private var identifierFactory: IdentifierFactory = IdentifierFactory()

    companion object {
        var teamStorage: MutableMap<Identifier, Team> = mutableMapOf()
    }

    fun generateTeamsForOneRound(teamsNumber: Int): List<Team> {
        val teams = mutableListOf<Team>()

        for (i in 0 until teamsNumber) {
            val teamIdentifier = identifierFactory.uniqueIdentifier()
            val team = Team(teamIdentifier)
            teams.add(team)
            teamStorage[teamIdentifier] = team
        }

        return teams
    }
}
