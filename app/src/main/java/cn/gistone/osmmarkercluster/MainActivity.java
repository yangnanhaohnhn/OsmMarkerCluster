package cn.gistone.osmmarkercluster;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.osm.mapapi.clusterutil.clustering.Cluster;
import com.osm.mapapi.clusterutil.clustering.ClusterItem;
import com.osm.mapapi.clusterutil.clustering.ClusterManager;

import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    MapView mMapView;
    private ClusterManager<ItemMarker> mClusterManager;
    /**
     * 存放marker点
     */
    private List<ItemMarker> itemList = new ArrayList<>();
    //is_List是否是列表数据
    boolean m_stop = true;
    /*中间偏上的视图*/
    LinearLayout lertop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marker_cluster_demo);

        new Util(this);
        mMapView = (MapView) findViewById(R.id.bmapView);
        lertop = findViewById(R.id.lerview);
        // 定义点聚合管理类ClusterManager
        mClusterManager = new ClusterManager<>(this, mMapView);
        // 添加Marker点
        addMarkers();



        mClusterManager.setOnClusterClickListener(new ClusterManager.OnClusterClickListener<ItemMarker>() {
            @Override
            public boolean onClusterClick(Cluster<ItemMarker> cluster) {
                Log.e("TAG", "onClusterClick: " +cluster.toString() );
                return false;
            }
        });
//        mClusterManager.setOnClusterItemClickListener(new ClusterManager.OnClusterItemClickListener<MyItem>() {
//            @Override
//            public boolean onClusterItemClick(MyItem item) {
//                Toast.makeText(MarkerClusterDemo.this,
//                        "点击单个Item", Toast.LENGTH_SHORT).show();
//
//                //点击时把这个点移动到屏幕中间
//                mBaiduMap.animateMapStatus(MapStatusUpdateFactory
//                        .newMapStatus(new MapStatus.Builder()
//                                .zoom(mBaiduMap.getMapStatus().zoom + 1)
//                                .target(item.getPosition())
//                                .build()));
//                lertop.setVisibility(View.VISIBLE);
//                return false;
//            }
//        });
//
//        mReadThread = new ReadThread();
//        mReadThread.start();
    }

    @Override
    protected void onPause() {
        mMapView.onPause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        mMapView.onResume();
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        m_stop=false;
        super.onDestroy();
    }

    /**
     * 向地图添加Marker点
     */
    public void addMarkers() {
        itemList.clear();
        mClusterManager.clearItems();

        int[] rint = produceNum(1,30000,10000);
        for (int i : rint) {
            String content = "第" + i + "点";
            GeoPoint geoPoint=new GeoPoint(39.996965+i*0.0001,116.411394+i*0.0001);
            ItemMarker myItem = new ItemMarker(this, geoPoint, content);
            itemList.add(myItem);
        }
        mClusterManager.addItems(itemList);
        mClusterManager.cluster();

        mClusterManager.setOnClusterClickListener(new ClusterManager.OnClusterClickListener<ItemMarker>() {
            @Override
            public boolean onClusterClick(Cluster<ItemMarker> cluster) {
                Log.e("TAG", "onClusterClick: " +cluster.toString() );
                return false;
            }
        });

        mClusterManager.setOnClusterItemClickListener(new ClusterManager.OnClusterItemClickListener<ItemMarker>() {
            @Override
            public boolean onClusterItemClick(ItemMarker item) {
                Log.e("TAG", "onClusterItemClick: " +item.toString() );

                //点击时把这个点移动到屏幕中间
                mMapView.getController().animateTo(item.getPosition());
                return false;
            }
        });
    }

    /**
     * 产生随机数字
     * @param minNum 最小数字
     * @param maxNum 最大数字
     * @param numCount 产生的数字个数
     * @return 结果数组
     */
    public int[] produceNum(int minNum, int maxNum, int numCount) {

        // 入参校验
        // 如果随机数的个数大于产生随机数的范围；或最大数小于最小数
        // 直接返回null，说明入参不符合要求
        if (numCount > (maxNum - minNum + 1) || maxNum < minNum) {
            return null;
        }

        // 存放结果的数组
        int[] resultArr = new int[numCount];

        // count 记录已产生的随机数的个数
        int count = 0;

        while(count < numCount) {

            // 产生随机数
            int num = (int) (Math.random() * (maxNum - minNum)) + minNum;

            // flag 定义本次产生的随机数是否已在数组中
            boolean flag = true;

            // 遍历数组中已产生的随机数
            for (int i=0; i<count; i++) {

                // 同本次产生的随机数最比较
                if (num == resultArr[i]) {

                    // 如果已存在相同的值，则跳出for循环，继续外层的while循环，产生下一个随机数
                    flag = false;
                    break;
                }
            }

            // 如果本次产生的随机数在数组中不存在，则将该随机数存放在数组中
            if (flag) {
                resultArr[count] = num;

                // 数组中已产生的随机数个数加1
                count++;
            }
        }

        return resultArr;
    }

}
