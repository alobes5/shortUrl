package shortened.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import shortened.repository.entity.UrlEntity;

@Repository
public interface ShortUrlRepository extends PagingAndSortingRepository<UrlEntity, Long> {

    public UrlEntity findByKey(String key);

}
