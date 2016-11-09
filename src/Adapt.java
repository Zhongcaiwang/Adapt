//适配器模式
public class Adapt {}

interface Target{
	public void request();
}//目标类，用户所需的接口
interface Adaptee{
	public void specificRequest();
}//适配者类，被适配的角色

class Adapter implements Target,Adaptee{
	private Target target;
	private Adaptee adaptee;
	public Adapter(Adaptee adaptee){
		this.adaptee = adaptee;
	}
	public Adapter(Target target){
		this.target = target;
	}
	public void request(){
		adaptee.specificRequest();
	}
	public void specificRequest() {
		target.request();
	}
}//适配器，作为转换器对adaptee和target进行适配

interface ScoreOperation{
	public int[] sort(int array[]);
	public int search(int array[],int key);
}

class QuickSort{//快速查找
	public int[] quickSort(int []array){
		sort(array, 0, array.length - 1);
		return array;
	}
	public void sort(int array[], int p, int r){
		int q = 0;
		if(p < r){//q没有越界
			q = partition(array, p, r);//找q的位置
			sort(array, p, q-1);//排q之前
			sort(array, q+1, r);//排q之后
		}
	}//p为头，r为尾
	public int partition(int []a, int p, int r){
		int x = a[r];
		int j = p - 1;
		for(int i = p; i <= r - 1; i++){
			if(a[i] <= x){
				j++;
				swap(a, j, i);//把比a[r]小的移到a[r]之前
			}
		}
		swap(a, j + 1, r);//比a[r]大的移到a[r]之后
		return j + 1;
	}//把比a[r]小的移到a[r]之前，比a[r]大的移到a[r]之后
	public void swap(int []a, int i, int j){
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
}

class BinarySearch{
	public int binarySearch(int array[], int key){
		int low = 0;
		int high = array.length - 1;
		while(low < high){
			int mid = (low + high) / 2;
			int midVal = array[mid];
			if(midVal < key){
				low = mid + 1;
			}else if(midVal > key){
				high = mid -1;
			}else{
				return 1;//找到返回1
			}
		}
		return -1;
	}
}

class OperationAdapter implements ScoreOperation{
	private QuickSort sortObj;//适配者对象
	private BinarySearch searchObj;//适配者对象
	
	public OperationAdapter() {
		// TODO Auto-generated constructor stub
		sortObj = new QuickSort();//实例
		searchObj = new BinarySearch();
	}
	@Override
	public int[] sort(int[] array) {
		// TODO Auto-generated method stub
		return sortObj.quickSort(array);//调用调用者类的方法
	}

	@Override
	public int search(int[] array, int key) {
		// TODO Auto-generated method stub
		return searchObj.binarySearch(array, key);//调用调用者类的方法
	}
}