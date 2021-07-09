package jp.ac.kobe_u.cs.itspecialist.todoapp.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jp.ac.kobe_u.cs.itspecialist.todoapp.entity.ToDo;

@Repository
public interface ToDoRepository extends CrudRepository<ToDo, Long> {
    //List<ToDo> findAll();
    //List<ToDo> findByDone(boolean done);
    //List<ToDo> findByMid(String mid);
    List<ToDo> findByMidAndDone(String mid, boolean done);

    /**
     * ページ送りを実現するためにListの代わりにPage型を返り値にとる
     */
    public Page<ToDo> findAll(Pageable pageable);
    public Page<ToDo> findByDone(boolean done, Pageable pageable);
    public Page<ToDo> findByMid(String mid, Pageable pageable);
    public Page<ToDo> findByMidAndDone(String mid, boolean done, Pageable pageable);
}
