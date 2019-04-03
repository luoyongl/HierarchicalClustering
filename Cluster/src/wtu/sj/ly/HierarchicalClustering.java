package wtu.sj.ly;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HierarchicalClustering {

	public List<Cluster> clusters = null;
	
	public Integer[][] array = new Integer[50][50]; 
	
	public HierarchicalClustering() throws IOException {
		initData();
	}
 
	/**
	 * ��ʼ�����ݼ�
	 * 
	 * @throws IOException
	 */
	private void initData() throws IOException {
		clusters = new ArrayList<Cluster>();
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(HierarchicalClustering.class
						.getClassLoader().getResourceAsStream("data.txt")));
		String line = null;
		int i = 0;
		while ((line = bufferedReader.readLine()) != null) {
			// \\s+ƥ��һ�����߶���ո�
			String[] s = line.split("\\s+");
			Cluster cluster = new Cluster();
			cluster.setId(i);
			cluster.setName(s[0]);
			cluster.setDistance(0);
			cluster.setLeft(null);
			cluster.setRight(null);
			for(int j=0;j<i;j++) {
				if (i>=j&&i>0) {
					array[i][j]=Integer.parseInt(s[j+1]);
					array[j][i]=Integer.parseInt(s[j+1]);
				}
			}
			i++;
			clusters.add(cluster);
		}
 
	}
	public Cluster hcluster() {
		// ��distances����������������֮��ľ���,����map���ϵļ�Ϊ���������id
		Map<Integer[], Double> distances = new HashMap<Integer[], Double>();
 
		int currentId = -1;
 
		while (clusters.size() > 1) {
			// ��̾����������id
			int lowestpair1 = 0;
			int lowestpair2 = 1;
			// ��̾���
			double closest = array[0][1];
 
			for (int i = 0; i < clusters.size(); i++) {
				for (int j = i + 1; j < clusters.size(); j++) {
					Integer[] key = { clusters.get(i).getId(),
							clusters.get(j).getId() };
					if (!distances.containsKey(key)) {
						distances.put(key, array[i][j].doubleValue());
					}
 
					double d = distances.get(key);
					if (d < closest) {
						closest = d;
						lowestpair1 = i;
						lowestpair2 = j;
					}
				}
			}
 
			// ����������̾�������ƽ��ֵ
			/*List<Double> midvec = mergevec(clusters.get(lowestpair1),
					clusters.get(lowestpair2));*/
			
			Cluster cluster = new Cluster(clusters.get(lowestpair1),clusters.get(lowestpair2),null,currentId,closest,"");
 
			currentId -= 1;
			
			//ע��ɾ��˳����ɾ�����id�ţ���������Խ��
			if (lowestpair1 < lowestpair2) {
				clusters.remove(clusters.get(lowestpair2));
				clusters.remove(clusters.get(lowestpair1));
			}else {
				clusters.remove(clusters.get(lowestpair1));
				clusters.remove(clusters.get(lowestpair2));
			}
			clusters.add(cluster);
		}
		return clusters.get(0);
	}
 
 
	/*private List<Double> mergevec(Cluster cluster1, Cluster cluster2) {
		List<Double> midvec = new ArrayList<Double>();
		for (int i = 0; i < cluster1.getVector().size(); i++) {
			midvec.add((cluster1.getVector().get(i) + cluster2.getVector().get(i)) / 2.0);
		}
		return midvec;	
	}*/
	
	/**
	 * ��ӡ���
	 */
	public void printCluster(Cluster cluster,int n) {
		/*for (int i = 0; i < n; i++) {
			System.out.print(" ");
		}*/
		//������Ǵ�������һ����֧
		if (cluster.getId() < 0) {
		//	System.out.println("-");
		//	System.out.println();
			System.out.println("F:"+cluster.getId()+"|"+ 
					"C:("+cluster.getLeft().getId()+":"+cluster.getLeft().getName()+","
			+cluster.getRight().getId()+":"+cluster.getRight().getName()+")");
			System.out.println();
		}else {
			//������һ��Ҷ�ӽڵ�	
			System.out.println(cluster.getId()+":"+cluster.getName());
			System.out.println();
		}
		
		
		if (cluster.getLeft()!= null) {
			//System.out.print("��");
			printCluster(cluster.getLeft(),++n);
		}
		if (cluster.getRight()!=null) {
			//System.out.print("��");
			printCluster(cluster.getRight(), ++n);
		}
	}
}
