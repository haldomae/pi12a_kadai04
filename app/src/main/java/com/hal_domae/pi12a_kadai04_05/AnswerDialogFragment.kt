package com.hal_domae.pi12a_kadai04_05

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class AnswerDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // アクティビティがnull(存在しているか)をチェックする
        val dialog = activity?.let {
            MaterialAlertDialogBuilder(it)
                // ダイアログのタイトル
                .setTitle(arguments?.getString("TITLE"))
                // ダイアログのメッセージ
                .setMessage(arguments?.getString("MESSAGE"))
                // ダイアログのボタン
                /*
                    * Positive : 肯定的なアクション(OK、同意するなど)
                    * Negative : 否定的なアクション(キャンセル、同意しないなど)
                    * Neutral : どちらでも無い場合(保留、あとでなど)
                    * */
                .setPositiveButton("OK") {_,_->
                    // OKを押したときに呼び出させるメソッドを指定
                    (activity as MainActivity).checkQuizCount()
                }.create()
        }
        return dialog ?: throw IllegalStateException("画面がないです")
    }
}