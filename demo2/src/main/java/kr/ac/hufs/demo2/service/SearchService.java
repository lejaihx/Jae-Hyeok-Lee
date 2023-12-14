package kr.ac.hufs.demo2.service;

import kr.ac.hufs.demo2.dto.SearchDto;
import kr.ac.hufs.demo2.naver.NaverClient;
import kr.ac.hufs.demo2.naver.dto.SearchLocalReq;
import kr.ac.hufs.demo2.naver.dto.SearchLocalRes;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchService {
    private final NaverClient naverClient;
    //private final DaumClient daumClient;
    //private final GoogleClient googleClient;

    public SearchLocalRes searchLocal(String query) {
        var searchReq = new SearchLocalReq();
        searchReq.setQuery(query);
        var searchRes = naverClient.searchLocal(searchReq);

        if (searchRes.getTotal() > 0) {
            //List<SearchLocalRes.SearchLocalItem> items = searchRes.getItems();
            //var item = searchRes.getItems().stream().findFirst().get();
            //var result = new SearcSearchLocalReshDto();
            //result.setTitle(item.getTitle());
            //result.setLink(item.getLink());
            //System.out.println(items.get(4));

            //BeanUtils.copyProperties(items.get(4), result);

            return searchRes;

        }

        return new SearchLocalRes();
    }
}
