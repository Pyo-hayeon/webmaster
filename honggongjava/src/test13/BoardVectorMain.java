package test13;

public class BoardVectorMain {

	public static void main(String[] args) {

		BoardVectorControl bvc = new BoardVectorControl();
		
		
		System.out.println(bvc.list.isEmpty());
		
		bvc.setBoard("제목1", "글쓴이1", "내용1");
		bvc.setBoard("제목2", "글쓴이2", "내용2");
		bvc.setBoard("제목3", "글쓴이3", "내용3");
		bvc.setBoard("제목4", "글쓴이4", "내용4");
		
		
		
		for(int i=0; i<bvc.list.size(); i++) {
			BoardVector bv =  bvc.list.get(i);
			System.out.printf("제목: %s\t내용: %s\t글쓴이: %s\n",bv.subject, bv.content, bv.writer);
		}
		
	}

}
