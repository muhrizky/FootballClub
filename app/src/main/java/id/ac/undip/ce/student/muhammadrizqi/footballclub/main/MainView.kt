package id.ac.undip.ce.student.muhammadrizqi.footballclub.main

import id.ac.undip.ce.student.muhammadrizqi.footballclub.model.Team

interface MainView {
    fun showLoading()
    fun  hideLoading()
    fun showTeamList(data: List<Team>)
}