package ru.gendalf13666.repo

import ru.gendalf13666.repo.model.data.dto.SearchResultDto

class RepositoryImplementation(private val dataSource: DataSource<List<SearchResultDto>>) :
    Repository<List<SearchResultDto>> {
    override suspend fun getData(word: String): List<SearchResultDto> = dataSource.getData(word)
}
