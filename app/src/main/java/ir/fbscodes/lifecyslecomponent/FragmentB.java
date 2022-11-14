package ir.fbscodes.lifecyslecomponent;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

public class FragmentB extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fargment_b, container, false);

        // By Shared ViewModel
        MyViewModel myViewModel = new ViewModelProvider(requireActivity()).get(MyViewModel.class);

        EditText email = view.findViewById(R.id.email);

        // By Shared ViewModel
        email.setText(myViewModel.getEmail());

        Button showResults = view.findViewById(R.id.show_results);
        showResults.setOnClickListener(v -> {
            if (email.length() < 1) {
                email.setError("is empty!");
            }else{
                // By Bundle Method
//                if (getArguments() != null) {
//                    Bundle bundle = new Bundle();
//                    bundle.putString("email", email.getText().toString());
//                    bundle.putString("firstName", getArguments().getString("first"));
//                    bundle.putString("lastName", getArguments().getString("last"));
//                    Navigation.findNavController(view).navigate(R.id.action_fragmentB_to_fragmentC, bundle);
//                }else{
//                    Navigation.findNavController(view).navigate(R.id.action_fragmentB_to_fragmentA);
//                }

                // By Shared ViewModel
                if (myViewModel.getFirstName().length() > 0 && myViewModel.getLastName().length() > 0) {
                    myViewModel.setEmail(email.getText().toString());
                    Navigation.findNavController(view).navigate(R.id.action_fragmentB_to_fragmentC);
                }else{
                    Navigation.findNavController(view).navigate(R.id.action_fragmentB_to_fragmentA);
                }
            }
        });
        return view;
    }
}
