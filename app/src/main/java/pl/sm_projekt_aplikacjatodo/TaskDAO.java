package pl.sm_projekt_aplikacjatodo;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TaskDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Task task);

    @Delete
    void delete(Task task);

    @Update
    void update(Task task);

    @Query("DELETE FROM Task")
    void deleteAll();

    @Query("SELECT * FROM Task")
    public List<Task> findAll();

    @Query("SELECT * FROM Task WHERE taskOwnerId = :taskOwnerId")
    public List<Task> findByTaskOwnerId(int taskOwnerId);
}