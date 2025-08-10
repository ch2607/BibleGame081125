package com.Game.ccmusa.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GameYandNList extends Activity
{
    GridView yandnGV;
    YandNGVAdapter adapter;
    Context ctx;
    int BUFFER_SIZE = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameyandnlist);
        ctx = getApplication();
        Main.myArrayYandn = new ArrayList<>();
        Main.myArrayYandNInf = new ArrayList<>();
        Main.error = 0;
        Main.ok = 0;
        Main.currentQuestion = 0;
        yandnGV = findViewById(R.id.idchoose);
        // ✅ 建立 Adapter
        final ArrayList<YandNModel> yandnModelArrayList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            yandnModelArrayList.add(new YandNModel(
                    String.valueOf(i),
                    R.drawable.choose,
                    getNumDrawable(i),
                    R.mipmap.err
            ));
        }
        adapter = new YandNGVAdapter(this, yandnModelArrayList);
        yandnGV.setAdapter(adapter);

        // ✅ 載入初始狀態
        loadGameStatus();

        yandnGV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,
                                    View view, int position, long id) {
                // 選擇玩第幾題 Position
                Main.ynum = position;
                // ✅ 只能開啟已解鎖的遊戲
                if ("1".equals(Main.myArrayYandn.get(position))) {
                    Intent intent = new Intent(GameYandNList.this, YandNGridList.class);
                    startActivity(intent);
                }
            }
        });

    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("cfh", "✅ onResume: 重新載入遊戲狀態");
        loadGameStatus();
        adapter.notifyDataSetChanged();
    }

    private void loadGameStatus() {
        Main.myArrayYandn = new ArrayList<>();
        Main.myArrayChInf = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            String name = (Main.setcn) ? "yse" + i + ".txt" : "ye" + i + ".txt";
            try {
                InputStream inputStream = ctx.openFileInput(name);
                BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), BUFFER_SIZE);
                String line;
                int ret = 0;
                while ((line = br.readLine()) != null) {
                    ret = Integer.parseInt(line);
                }
                br.close();

                // ✅ 更新狀態
                if (ret == 1) { // 全對
                    Main.myArrayYandn.add("1");
                    Main.myArrayYandNInf.add("1");
                    Main.saveindx = i;
                } else if (ret == 2) { // 有錯
                    Main.myArrayYandn.add("1");
                    Main.myArrayYandNInf.add("2");
                    Main.saveindx = i;
                    Main.saveerr = ret;
                } else {
                    Main.myArrayYandn.add("1");
                    Main.myArrayYandNInf.add("3");
                    Main.saveerr = ret;
                    Main.saveindx = i;
                }

            } catch (IOException e) {
                if (i == 0) {
                    // ✅ 第一個遊戲預設解鎖
                    Main.myArrayYandn.add("1");
                    Main.myArrayYandNInf.add("0");
                } else {
                    // ✅ 其他遊戲預設鎖住
                    if (i == Main.saveindx + 1) {
                        Main.myArrayYandn.add("1");
                        Main.myArrayYandNInf.add("0");
                    } else {
                        Main.myArrayYandn.add("0");
                        Main.myArrayYandNInf.add("0");
                    }
                }
            }
            Log.d("cfh", "遊戲 " + i + " 狀態: " + Main.myArrayYandNInf.get(i));
        }
    }
    private int getNumDrawable(int index) {
        switch (index) {
            case 0: return R.drawable.num01;
            case 1: return R.drawable.num02;
            case 2: return R.drawable.num03;
            case 3: return R.drawable.num04;
            case 4: return R.drawable.num05;
            case 5: return R.drawable.num06;
            case 6: return R.drawable.num07;
            case 7: return R.drawable.num08;
            case 8: return R.drawable.num09;
            case 9: return R.drawable.num10;
            case 10: return R.drawable.num11;
            case 11: return R.drawable.num12;
            case 12: return R.drawable.num13;
            case 13: return R.drawable.num14;
            case 14: return R.drawable.num15;
            case 15: return R.drawable.num16;
            case 16: return R.drawable.num17;
            case 17: return R.drawable.num18;
            case 18: return R.drawable.num19;
            case 19: return R.drawable.num20;
            case 20: return R.drawable.num21;
            case 21: return R.drawable.num22;
            case 22: return R.drawable.num23;
            case 23: return R.drawable.num24;
            case 24: return R.drawable.num25;
            case 25: return R.drawable.num26;
            case 26: return R.drawable.num27;
            case 27: return R.drawable.num28;
            case 28: return R.drawable.num29;
            case 29: return R.drawable.num30;
            default: return R.drawable.num01;
        }
    }
}
