package dev.rivaldi.springdatamanytooneexamples;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface BrandRepository extends PagingAndSortingRepository<Brand, Long> {
}
