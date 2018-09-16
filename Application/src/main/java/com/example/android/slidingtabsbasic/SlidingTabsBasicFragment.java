/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.slidingtabsbasic;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.common.view.SlidingTabLayout;


public class SlidingTabsBasicFragment extends Fragment {

    private SlidingTabLayout mSlidingTabLayout;
    private ViewPager mViewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sample, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        mViewPager = (ViewPager) view.findViewById(R.id.viewpager);
        mViewPager.setAdapter(new SamplePagerAdapter());

        mSlidingTabLayout = (SlidingTabLayout) view.findViewById(R.id.sliding_tabs);
        mSlidingTabLayout.setViewPager(mViewPager);

    }

    class SamplePagerAdapter extends PagerAdapter {

        //Quando alterar o array de letras vc deve mudar este valor ex: array possui
        // 12 letras
        @Override
        public int getCount() {
            return 12;
        }

        @Override
        public boolean isViewFromObject(View view, Object o) {
            return o == view;
        }

        // Array contendo 12 letras, vc deve alterar
        @Override
        public CharSequence getPageTitle(int position) {
            String[] letras = {"A","B","C","D","E","F","G","H","I","J","K","L"};
            return letras[position];
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            View view = getActivity().getLayoutInflater().inflate(R.layout.pager_item,
                    container, false);

            container.addView(view);

            ImageView letra = (ImageView) view.findViewById(R.id.item_title);

            // Apenas exemplo com 7 letras, você deve alterar para abranger as outras
            // Usei as imagens do seu projeto, mas estão com definição ruim.
            // As imagens estão na pasta res/drawable
            letra.setImageResource(imageResource(position));

            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);

        }

        public int imageResource(int position){
            int resource = 0;

            switch (position){
                case 0:
                    resource = R.drawable.a;
                    break;
                case 1:
                    resource = R.drawable.b;
                    break;
                case 2:
                    resource = R.drawable.c;
                    break;
                case 3:
                    resource = R.drawable.d;
                    break;
                case 4:
                    resource = R.drawable.e;
                    break;
                case 5:
                    resource = R.drawable.f;
                    break;
                case 6:
                    resource = R.drawable.g;
                    break;

            }

            return resource;
        }

    }
}
