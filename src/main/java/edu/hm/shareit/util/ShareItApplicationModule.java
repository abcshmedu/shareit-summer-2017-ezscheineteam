package edu.hm.shareit.util;

import com.google.inject.AbstractModule;
import edu.hm.shareit.business.CopyService;
import edu.hm.shareit.business.CopyServiceImplStub;
import edu.hm.shareit.business.MediaService;
import edu.hm.shareit.business.MediaServiceImpl;
import edu.hm.shareit.repository.MediaRepository;
import edu.hm.shareit.repository.MediaRepositoryHibernate;

/**
 * Guice Bind Module fuer ShareIT.
 */
public class ShareItApplicationModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(MediaService.class).to(MediaServiceImpl.class);
        bind(MediaRepository.class).to(MediaRepositoryHibernate.class);
        bind(CopyService.class).to(CopyServiceImplStub.class);
        bind(TokenHandler.class).to(AuthServToken.class);
    }

}
