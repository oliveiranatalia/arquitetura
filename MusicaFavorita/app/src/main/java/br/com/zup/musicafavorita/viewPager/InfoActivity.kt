package br.com.zup.musicafavorita.viewPager

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import br.com.zup.musicafavorita.R
import br.com.zup.musicafavorita.databinding.ActivityInfoBinding
import br.com.zup.musicafavorita.viewPager.adapter.InfoPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class InfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInfoBinding
    private val options = listOf("Informações", "Albuns")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        appBar()
        showViewPagerTabLayout()
    }
    private fun appBar(){
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(R.string.app_name)
    }
    private fun showViewPagerTabLayout(){
        val infoPagerAdapter = InfoPagerAdapter(supportFragmentManager,lifecycle, options)
        binding.vpInfo.adapter = infoPagerAdapter

        TabLayoutMediator(binding.tlInfo, binding.vpInfo){ tab, position -> tab.text = options[position]}.attach()
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            this.finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}