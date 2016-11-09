//������ģʽ
public class Adapt {}

interface Target{
	public void request();
}//Ŀ���࣬�û�����Ľӿ�
interface Adaptee{
	public void specificRequest();
}//�������࣬������Ľ�ɫ

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
}//����������Ϊת������adaptee��target��������

interface ScoreOperation{
	public int[] sort(int array[]);
	public int search(int array[],int key);
}

class QuickSort{//���ٲ���
	public int[] quickSort(int []array){
		sort(array, 0, array.length - 1);
		return array;
	}
	public void sort(int array[], int p, int r){
		int q = 0;
		if(p < r){//qû��Խ��
			q = partition(array, p, r);//��q��λ��
			sort(array, p, q-1);//��q֮ǰ
			sort(array, q+1, r);//��q֮��
		}
	}//pΪͷ��rΪβ
	public int partition(int []a, int p, int r){
		int x = a[r];
		int j = p - 1;
		for(int i = p; i <= r - 1; i++){
			if(a[i] <= x){
				j++;
				swap(a, j, i);//�ѱ�a[r]С���Ƶ�a[r]֮ǰ
			}
		}
		swap(a, j + 1, r);//��a[r]����Ƶ�a[r]֮��
		return j + 1;
	}//�ѱ�a[r]С���Ƶ�a[r]֮ǰ����a[r]����Ƶ�a[r]֮��
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
				return 1;//�ҵ�����1
			}
		}
		return -1;
	}
}

class OperationAdapter implements ScoreOperation{
	private QuickSort sortObj;//�����߶���
	private BinarySearch searchObj;//�����߶���
	
	public OperationAdapter() {
		// TODO Auto-generated constructor stub
		sortObj = new QuickSort();//ʵ��
		searchObj = new BinarySearch();
	}
	@Override
	public int[] sort(int[] array) {
		// TODO Auto-generated method stub
		return sortObj.quickSort(array);//���õ�������ķ���
	}

	@Override
	public int search(int[] array, int key) {
		// TODO Auto-generated method stub
		return searchObj.binarySearch(array, key);//���õ�������ķ���
	}
}