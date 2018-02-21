package test.IA.minimax;

public class Main {

}

class GameOfBones {
	static List<Integer> getPossibleStates(int noOfBonesInHeap) {
		return IntStream.rangeClosed(1, 3).boxed().map(i -> noOfBonesInHeap - i)
				.filter(newHeapCount -> newHeapCount >= 0).collect(Collectors.toList());
	}
}
