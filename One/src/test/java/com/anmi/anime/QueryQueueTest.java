package com.anmi.anime;

import com.anmi.anime.model.GafisDakuQueryqueEntity;
import com.anmi.anime.model.vo.QueryQueueVO;
import com.anmi.anime.repository.daku.GafisNormalqueryQueryqueRepository;
import com.anmi.anime.repository.daku.QueryqueueRepository;
import com.anmi.anime.service.GafisNormalqueryQueryqueService;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


/**
 * Created by wangjue on 2017/9/14.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryQueueTest {
    @Autowired
    GafisNormalqueryQueryqueService gafisNormalqueryQueryqueService;
    @Autowired
    QueryqueueRepository queryqueueRepository;
    @Autowired
    GafisNormalqueryQueryqueRepository gafisNormalqueryQueryqueRepository;

    @Test
    public void test_cc() {
        List<GafisDakuQueryqueEntity> list = gafisNormalqueryQueryqueService.getQueryqueueNotMatched();
        Assert.assertTrue(list != null && list.size() > 0);
    }

    @Test
    public void test_sendQuery() throws Throwable{
        List<String> keyIds_latent = new ArrayList<>();
        keyIds_latent.add("A110101300999201701160104");
        keyIds_latent.add("A110101300999201701160105");
        keyIds_latent.add("A110101300999201701160106");
        keyIds_latent.add("A110101300999201701160107");
        QueryQueueVO queryQueueVO_latent = new QueryQueueVO(keyIds_latent,2);

        List<String> keyIds_template = new ArrayList<>();
        keyIds_template.add("P1201606071465267040127");
        keyIds_template.add("P1201606071465284742760");
        keyIds_template.add("P1201606061465194820790");
        keyIds_template.add("P1201606061465192608162");
        for (int i = 0;i < 1000;i++) {
            keyIds_template.add("P1201606061465192608162");
        }
        QueryQueueVO queryQueueVO_template = new QueryQueueVO(keyIds_template,0);
        gafisNormalqueryQueryqueService.sendQuery(queryQueueVO_template);
    }

    @Test
    public void test_getMatchResult() {
        QueryQueueVO queryQueueVO = new QueryQueueVO();
        queryQueueVO.setOraSidS(56321);
        queryQueueVO.setOraSidE(56508);
        queryQueueVO.setMatchResultSavePath("/matchResult/"+ LocalDate.now()+"/exportFile");
        String currentMatchResultDir = gafisNormalqueryQueryqueService.getMatchResult(queryQueueVO);
        System.out.println(currentMatchResultDir);
    }

    @Test
    public void test_spilt() {
        String s = "11111,22222";
        String[] valid = s.split(" |\t|,");
        Assert.assertEquals(valid[0],"22222");
    }

    @Test
    public void test_Stream() throws IOException{
        List<String> matchList = new ArrayList<>();
        List<String> truePairList = new ArrayList<>();
        truePairList.add("A130185000999201209110101 R2305160008882009010145_3\n");
        truePairList.add("A310104000999201108004602 P1201606281467093643488_10\n");
        truePairList.add("A330203000999201204005601 P1111111111111111111111_6\n");
        Map<String,String> matchMap = new HashMap<>();      //真实对子
        truePairList.forEach( t -> {
            if (!t.isEmpty()) {
                String[] arr = t.split(" ");
                matchMap.put(arr[0], arr[1]);
            }
        });
        Collection<File> files = FileUtils.listFiles(new File("C:\\Users\\wangjue\\Desktop\\analysis\\lt"), new String[]{"txt"}, true);
        Iterator<File> it = files.iterator();
        while (it.hasNext()) {
            File ltCandListFile = it.next();
            String queryKey = ltCandListFile.getName().substring(0,ltCandListFile.getName().lastIndexOf("."));
            String trueMatchKey = matchMap.get(queryKey);
            if (trueMatchKey != null) {
                String[] trueMatchKeyArr = trueMatchKey.split("_");
                List<String> ltCandList = FileUtils.readLines(ltCandListFile);
                List<String> ltCandListWithRank = new ArrayList<>();
                ltCandList.stream().skip(3).collect(Collectors.toList()).forEach(t -> ltCandListWithRank.add(t+"--"+(ltCandListWithRank.size()+1)+"--"+queryKey));
                List<String> processList = ltCandListWithRank.stream().filter(t -> {
                    String[] arr = t.split("--");
                    if (arr.length > 3) return arr[0].equals(trueMatchKeyArr[0].trim()) && arr[2].equals(trueMatchKeyArr[1].trim());
                    else return false;
                }).collect(Collectors.toList());
                matchList.addAll(processList);
            }
        }
        matchList.stream().forEach(System.out::println);
    }

    @Test
    public void test_percent(){
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(2);
        String result = numberFormat.format((double) 12/(double) 171*100);
        System.out.println(result+"%");
    }

    @Test
    public void test_sqlReult(){
        long recordNumMatched = 5000000L;
        int oraSidStart = 11078;
        int oraSidEnd = 12048;
        List list = gafisNormalqueryQueryqueRepository.getMatchBeginAndFinishTimeAndAlgotithmQuerySpeed(recordNumMatched,oraSidStart,oraSidEnd);
        Object[] o = (Object[]) list.get(0);
        System.out.println(o[0]);

    }
}
