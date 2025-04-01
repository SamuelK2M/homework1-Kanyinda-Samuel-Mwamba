package jetbrains.kotlin.course.alias.results

import jetbrains.kotlin.course.alias.team.Team
import jetbrains.kotlin.course.alias.team.TeamService
import org.springframework.stereotype.Service

typealias GameResult = List<Team>

@Service
class GameResultsService {
    fun saveGameResults(result: GameResult): Unit {
        if (result.isEmpty()){
            throw IllegalArgumentException("No Results Found!")
        }

        val allIdsExist = result.all { team -> TeamService.teamStorage.containsKey(team.id) }

        if (!allIdsExist){
            throw IndexOutOfBoundsException("Wrong Teams IDs")
        }

        gameHistory.add(result)
    }

    fun getAllGameResults(): List<GameResult>{
        return gameHistory.asReversed()
    }

    companion object {
        var gameHistory: MutableList<GameResult> = mutableListOf()
    }
}
