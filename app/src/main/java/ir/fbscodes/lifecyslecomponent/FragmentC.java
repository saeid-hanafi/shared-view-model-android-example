package ir.fbscodes.lifecyslecomponent;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

public class FragmentC extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_c, container, false);
        TextView firstNameTv = view.findViewById(R.id.firstnameTv);
        TextView lastNameTv = view.findViewById(R.id.lastnameTv);
        TextView emailTv = view.findViewById(R.id.emailTv);

        // By Bundle Method
//        if (getArguments() != null) {
//            firstNameTv.setText(getArguments().getString("firstName"));
//            lastNameTv.setText(getArguments().getString("lastName"));
//            emailTv.setText(getArguments().getString("email"));
//        }else{
//            Navigation.findNavController(view).navigate(R.id.action_fragmentC_to_fragmentA);
//        }

        // By Shared ViewModel
        MyViewModel myViewModel = new ViewModelProvider(requireActivity()).get(MyViewModel.class);
        String firstName = myViewModel.getFirstName();
        String lastName = myViewModel.getLastName();
        String email = myViewModel.getEmail();
        if (firstName.length() > 0 && lastName.length() > 0 && email.length() > 0) {
            firstNameTv.setText(firstName);
            lastNameTv.setText(lastName);
            emailTv.setText(email);
        }else{
            Navigation.findNavController(view).navigate(R.id.action_fragmentC_to_fragmentA);
        }
        return view;
    }
}
