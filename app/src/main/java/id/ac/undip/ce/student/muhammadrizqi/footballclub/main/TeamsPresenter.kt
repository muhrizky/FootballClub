package id.ac.undip.ce.student.muhammadrizqi.footballclub.main

import com.google.gson.Gson
import id.ac.undip.ce.student.muhammadrizqi.footballclub.api.ApiRespository
import id.ac.undip.ce.student.muhammadrizqi.footballclub.model.TeamResponse
import id.ac.undip.ce.student.muhammadrizqi.footballclub.api.TheSportDBApi
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class TeamsPresenter(
        private val view: TeamsView,
        private val apiRespository: ApiRespository,
        private val gson: Gson
) {
    fun getteamList(league: String?){
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRespository.doRequest(TheSportDBApi.getTeams(league)), TeamResponse::class.java)
            uiThread {
                view.hideLoading()
                view.showTeamList(data.teams)
            }
        }
    }
}