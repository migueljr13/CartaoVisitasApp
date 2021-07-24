package ui

import Listeners
import adapter.BusinessCardAdapter
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.com.dio.businesscard.util.Image
import com.courses.businesscard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Listeners {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }
    private val adapter by lazy { BusinessCardAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.rvCard.adapter = adapter
        
        getAllBusinessCard()
        insertListerners()
    }

    override fun insertListerners() {
        binding.fab.setOnClickListener {
            val intent = Intent(this, AddBusinessCardActivity::class.java)
            startActivity(intent)
        }

        adapter.listenerShare  = { card ->
           Image.share(this@MainActivity,card)
        }
    }

    private fun getAllBusinessCard() {
        mainViewModel.getAll().observe(this, {})
    }
}