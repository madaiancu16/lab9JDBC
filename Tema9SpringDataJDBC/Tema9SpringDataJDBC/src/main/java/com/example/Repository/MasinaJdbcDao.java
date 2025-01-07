package com.example.Repository;

import com.example.MasinaMapper;
import com.example.entity.Masina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class MasinaJdbcDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Masina> findAll() {
        String sql = "select * from masini";
        return jdbcTemplate.query(sql, new MasinaMapper());
    }

    public Masina findByNr_inmatriculare(String nr_inmatriculare) {
        String sql = "select * from masini where nr_inmatriculare = ?";
        return jdbcTemplate.queryForObject(sql, new MasinaMapper(), nr_inmatriculare);
    }

    public int countByMarca(String marca) {
        String sql = "select count(*) from masini where marca = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, marca);
    }

    public int countByNr_kilometrii_smallerThan(int nr_kilometrii) {
        String sql = "select count(*) from masini where nr_kilometrii < ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, nr_kilometrii);
    }

    public List<Masina> findMasiniNoi(int an_curent) {
        String sql = "select * from masini where an_fabricatie >= ?";

        return jdbcTemplate.query(sql, new MasinaMapper(), an_curent-5);
    }

    public int deleteByNr_inmatriculare(String nr_inmatriculare) {
        String sql = "delete from masini where nr_inmatriculare = ?";
        return jdbcTemplate.update(sql, nr_inmatriculare);
    }

    public int insert(Masina masina) {
        String sql = "insert into masini values(?,?,?,?,?)";
        return jdbcTemplate.update (sql,
                masina.getNr_inmatriculare(),
                masina.getMarca(),
                masina.getAn_fabricatie(),
                masina.getCuloare(),
                masina.getNr_kilometrii());
    }
}