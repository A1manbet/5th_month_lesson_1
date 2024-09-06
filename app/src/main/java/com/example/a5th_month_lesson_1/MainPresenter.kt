package com.example.a5th_month_lesson_1

class MainPresenter {

    private val model = CounterModel()
    private var contract: CounterContract? = null

    fun attachContract(contract: CounterContract) {
        this.contract = contract
        contract.showResult(model.getCount())
    }

    fun onIncrement() {
        model.increment()
        contract?.showResult(model.getCount())
        if (model.getCount() == 10) {
            contract?.showToast()
        } else if (model.getCount() == 15) {
            contract?.changeColor()
        }
    }

    fun onDecrement() {
        model.decrement()
        contract?.showResult(model.getCount())
        if (model.getCount() == 10) {
            contract?.showToast()
        } else if (model.getCount() == 15) {
            contract?.changeColor()
        }
    }

    fun detachContract() {
        contract = null
    }

}