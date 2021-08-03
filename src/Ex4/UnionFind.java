package Ex4;

import java.awt.Point;

public class UnionFind {
	public double angle;//Add class properties
	public Point []elements;
	public int [] weight;
	public int [] id;
	Point p;




	public UnionFind(int size, double angle) {
		this.angle=angle;
		this.id=new int[size];
		this.weight=new int[size];
		this.p= new Point(50,50);
		this.elements=Ex4Utils.generateRandomArray(size);
		for(int i=0;i<this.id.length;i++) {
			this.id[i]=i;
		}
		UnionByAngularDist(p);

	}
	//O(logn)
	public int Find(int p) {
		if(id[p]==p) return p;
		else return Find(id[p]);
	}
	//O(n);
	public void doisJoin() {
		for(int i=0;i<this.id.length;i++) {
			this.id[i]=i;
		}
	}
	public void Union(int ind1, int ind2) {
		int group_d1 = Find(ind1); 
		int group_d2 = Find(ind2);
		if(id[group_d1]>id[group_d2]) {
			id[group_d1]=group_d2;
			weight[group_d1]+=weight[group_d2];

		}
		else {
			id[group_d2]=group_d1;
			weight[group_d2]+=weight[group_d1];
		}
	}

	public void increaseAngle(int d) {
		this.angle=this.angle+d;
		UnionByAngularDist(p);
	}

	public void UnionByAngularDist(Point p) {//o(n*360/angle)
		double first=0;
		for (double i = this.angle; i <= 360; i=i+this.angle) {//o(360/angle)
			int n=0;
			if(first>0) {
				while((Ex4Utils.angleFrom(p, this.elements[n])<=i)==false||(first<=Ex4Utils.angleFrom(p, this.elements[n]))==false) {//o(n)
					n++;
				}
				int o = n;
				while(o<elements.length) {//o(n-j)
					if((Ex4Utils.angleFrom(p, this.elements[o])<=i)&&(first<Ex4Utils.angleFrom(p, this.elements[o]))){
						Union(n, o);//O(logn)
					}
					o++;
				}
				first=first+this.angle;
			}else {
				while((Ex4Utils.angleFrom(p, this.elements[n])<=i)==false||(first<Ex4Utils.angleFrom(p, this.elements[n]))==false) {//o(n)
					n++;
				}
				int o = n;
				while(o< elements.length) {//o(n-j)
					if((Ex4Utils.angleFrom(p, this.elements[o])<=i)&&(first<=Ex4Utils.angleFrom(p, this.elements[o]))){
						Union(id[n],id[o]);//O(logn)
					}
					o++;
				}
				first=first+this.angle;
			}
		}
	}
}

