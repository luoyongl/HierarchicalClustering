package wtu.sj.ly;

import java.io.IOException;

public class Mian {

	public static void main(String[] args) throws IOException {
		HierarchicalClustering hierarchicalClustering = new HierarchicalClustering();
		hierarchicalClustering.printCluster(hierarchicalClustering.hcluster(), 0);
	}

}
