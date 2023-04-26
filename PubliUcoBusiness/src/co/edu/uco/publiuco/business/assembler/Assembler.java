package co.edu.uco.publiuco.business.assembler;

public interface Assembler <D, T, E> {
	
	T toDTOfromDomain(D domain);
	D toDomainFromDto(T dto);
	E toEntityFromDomain(D domain);
	D toDomainFromEntity(E entity);
}
