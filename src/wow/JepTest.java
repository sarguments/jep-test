package wow;

import jep.Jep;
import jep.JepException;
import jep.NDArray;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JepTest {
    public static void main(String[] args) {
        try (Jep jep = new Jep()) {
            jep.eval("from krwordrank.word import KRWordRank");
            jep.eval("import krwordrank");
            jep.eval("print(krwordrank.__version__)");
            jep.eval("texts = ['그런데 져도, 밴픽때문에 져서 선수들이 아~감독님 ㅠㅠ 이렇게 긍정적으로 반응하고, 나중에 이기면 씨맥이 이건 내 설계였다 이렇게 말할거 같다']");
            jep.eval("wordrank_extractor = KRWordRank(min_count = 1, max_length = 10, verbose = True)");
            jep.eval("beta = 0.85    # PageRank의 decaying factor beta");
            jep.eval("max_iter = 10");
            jep.eval("keywords, rank, graph = wordrank_extractor.extract(texts, beta, max_iter)");
            jep.eval("extractedItems = list(keywords.items())");

            List<Map<String, Float>> results = (List<Map<String, Float>>) jep.getValue("extractedItems");

            System.out.println();

            System.out.println(results.toArray().getClass());

            for (int i = 0; i < results.size(); i++) {
                System.out.println(results.get(i));
            }

        } catch (JepException e) {
            e.printStackTrace();
        }
    }
}
