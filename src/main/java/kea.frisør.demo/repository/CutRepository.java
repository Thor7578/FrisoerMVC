package kea.frisør.demo.repository;

import kea.frisør.demo.model.Cut;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CutRepository extends CrudRepository<Cut, Integer>
{
    List<Cut> findCutsByTitleContaining (String title);
    List<Cut> findCutsByVisibleOnSiteTrue();
}
