package br.com.zup.musicafavorita.swipeViews.view.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import br.com.zup.musicafavorita.albumsList.view.AlbumsListFragment
import br.com.zup.musicafavorita.bandInformations.view.InfoFragment

class InfoPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle, private var options:List<String>
):FragmentStateAdapter(fragmentManager, lifecycle){

    override fun getItemCount(): Int = options.size

    override fun createFragment(position: Int): Fragment {
        when(position){
            0 -> return InfoFragment()
            1 -> return AlbumsListFragment()
        }
        return InfoFragment()
    }
}