package ui

import Listeners
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.courses.businesscard.databinding.ActivityAddBusinessCardBinding
import data.BusinessCard

class AddBusinessCardActivity : AppCompatActivity(), Listeners {

    private val binding by lazy { ActivityAddBusinessCardBinding.inflate(layoutInflater) }
    private val mainViewModel : MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun insertListerners() {
        binding.ibFechar.setOnClickListener {
            finish()
        }

        binding.btnConfirmar.setOnClickListener {

            val businessCard = BusinessCard(
                nome = binding.tilName.editText?.text.toString(),
                empresa = binding.tilEmpresa.editText?.text.toString(),
                telefone = binding.tilTelefone.editText?.text.toString(),
                email = binding.tilEmail.editText?.text.toString(),
                fundoPersonalizado = binding.tilCor.editText?.text.toString()
            )
            mainViewModel.insert(businessCard)
            finish()
        }
    }
}