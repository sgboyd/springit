package com.stevenboyd.springit.repository;

import com.stevenboyd.springit.domain.Link;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<Link, Long> {

}
