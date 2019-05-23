package net.msgnetconomy.travel.populator;

public interface GenericPopulator<T, E> {

    E populate(T source, E target);
}
